//eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export const getTaskList = async (id) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/board/listOfEnabledTasksByIdBoard/${id}`;

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

export const getFindBoard = async (id) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/board/${id}`;

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

export const postListTask = async (id, name) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/task/new/${id}`;

	try {
		const response = await fetch(url, {
			method: 'POST',
			mode: 'cors',
			body: JSON.stringify({
				name: `${name}`,
				description: `${name}`,
			}),
			headers: {
				'Content-Type': 'application/json',
				Authorization: `Bearer ${token}`,
			},
		});

		if (!response.ok) {
			console.log(response);
			throw new Error(`Error en la solicitud: ${response.status}`);
		}

		const data = await response.json();
		return data;
	} catch (error) {
		// console.error('Error al obtener la lista de espacios del usuario:', error);
		// throw error;
	}
};

export const disableTasks = async (id) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/task/disable/${id}`;
	console.log('URL:', url);
	try {
		const response = await fetch(url, {
			method: 'PUT',
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error deleting task column:' };
		}
	} catch (error) {
		console.error('Error deleting task column:', error);
	}
};

/*Crear Cards en las listas*/
export const postActivity = async (idTask, name, idUser) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/activity/new/${idTask}/${idUser}`;

	try {
		const response = await fetch(url, {
			method: 'POST',
			mode: 'cors',
			body: JSON.stringify({
				name: `${name}`,
				description: `${name}`,
			}),
			headers: {
				'Content-Type': 'application/json',
				Authorization: `Bearer ${token}`,
			},
		});

		if (!response.ok) {
			console.log(response);
			throw new Error(`Error en la solicitud: ${response.status}`);
		}

		const data = await response.json();

		return data;
	} catch (error) {
		console.error('Error al realizar la solicitud:', error);
		throw error;
	}
};

/*Traer la lista de cards de una Task*/
export const getListActiviy = async (idTask) => {
	const token = localStorage.getItem('token');
	const url = `${apiUrl}/task/listOfEnabledActivitiesByIdTask/${idTask}`;

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

		if (data === undefined) {
			return [];
		}

		return data;
	} catch (error) {
		// console.error('Error al obtener la lista de espacios del usuario:', error);
		// throw error;
	}
};
