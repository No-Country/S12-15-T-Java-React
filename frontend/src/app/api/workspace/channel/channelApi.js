// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export const getMessages = async (idChannel) => {
	const token = localStorage.getItem('token');
	console.log(
		'idChannel: ' + idChannel,
		'Token: ' + token,
		'url: ' + `${apiUrl}/channel/chat?idChannel=${idChannel}`,
		'payload: ' +
			{
				method: 'GET',
				headers: {
					Authorization: `Bearer ${token}`,
					'Content-Type': 'application/json',
				},
			}
	);
	try {
		const response = await fetch(
			`${apiUrl}/channel/chat?idChannel=${idChannel}`,
			{
				method: 'GET',
				mode: 'cors',
				headers: {
					'Content-Type': 'application/json',
					Authorization: `Bearer ${token}`,
				},
			}
		);
		if (response.ok) {
			const rawData = await response.text();
			console.log('response ok');
			const isValidJson = rawData.trim() !== '' && rawData.startsWith('[');

			if (isValidJson) {
				const data = JSON.parse(rawData);
				console.log('valid json');
				// Ordenar los datos por fecha
				const sortedData = data.sort((a, b) => {
					return new Date(b.localDateTime) - new Date(a.localDateTime);
				});

				return { success: true, data: sortedData };
			} else {
				return { success: false, error: 'Empty or invalid JSON response' };
			}
		} else {
			return { success: false, error: 'Error fetching messages data:' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error fetching messages data:' };
	}
};

export const sendMessage = async (idChannel, message) => {
	const token = localStorage.getItem('token');
	const user = JSON.parse(localStorage.getItem('user'));

	try {
		const response = await fetch(
			`${apiUrl}/channel/sendComment?idUser=${user.id}&idChannel=${idChannel}`,
			{
				method: 'POST',
				headers: {
					Authorization: `Bearer ${token}`,
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({ text: message }),
			}
		);
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error fetching new message:' };
		}
	} catch (error) {
		console.error('Error fetching new message', error);
	}
};
