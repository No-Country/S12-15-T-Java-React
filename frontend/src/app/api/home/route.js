//eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export const getListSpace = async (id) => {
	const url = `${apiUrl}/users/getallenabledspacesfromenableduserid/${id}`;
	const token = localStorage.getItem('token');

	try {
		const response = await fetch(url, {
			method: 'GET',
			mode: 'cors',
			headers: {
				'Content-Type': 'application/json',
				Authorization: `Bearer ${token}`,
			},
		});

		if (!response.ok) {
			throw new Error(`Error en la solicitud: ${response.status}`);
		}

		const data = await response.json();

		if (!data) {
			return undefined;
		}

		return data;
	} catch (error) {
		// console.error('Error al obtener la lista de espacios del usuario:', error);
		// throw error;
	}
};
