// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export const createWorkspace = async (
	userId,
	token,
	proyectName,
	description
) => {
	try {
		const response = await fetch(`${apiUrl}/space/create/${userId}`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				Authorization: `Bearer ${token}`,
			},
			body: JSON.stringify({
				name: proyectName,
				description: description,
			}),
		});

		if (response.ok) {
			const data = await response.json();
			const idSpace = data.idSpace;
			localStorage.setItem('space', JSON.stringify(data));
			return { success: true, idSpace };
		} else {
			const errorData = await response.json();
			console.error(errorData);
			return { success: false, error: errorData };
		}
	} catch (error) {
		console.error('Error', error);
		return { success: false, error: 'Error en la petición' };
	}
};
