// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;
const token = localStorage.getItem('token');
const user = JSON.parse(localStorage.getItem('user'));

export const getMessages = async (idChannel) => {
	try {
		const response = await fetch(
			`${apiUrl}/channel/chat?idChannel=${idChannel}`,
			{
				headers: {
					Authorization: `Bearer ${token}`,
					'Content-Type': 'application/json',
				},
			}
		);
		if (response.ok) {
			const data = await response.json();

			const sortedData = data.sort((a, b) => {
				return new Date(b.localDateTime) - new Date(a.localDateTime);
			});
			return { success: true, data: sortedData };
		} else {
			return { success: false, error: 'Error fetching messages data:' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error fetching messages data:' };
	}
};

export const sendMessage = async (idChannel, message) => {
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
