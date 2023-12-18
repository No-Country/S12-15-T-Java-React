export const projects = [
	{
		id: 1,
		nameProject: 'No Country-S12-15-T-Java-React',
		nameUser: 'Diego',
		imgProject: '/images/projects.jpg',
		members: [
			{
				id: 1,
				imgProject: '/images/user.png',
			},
			{
				id: 2,
				imgProject: '/images/user.png',
			},
			{
				id: 3,
				imgProject: '/images/user.png',
			},
		],
	},
	{
		id: 2,
		nameProject: 'Seleccionado',
		nameUser: 'Diego',
		imgProject: '/images/projects.jpg',
		members: [
			{
				id: 1,
				imgProject: '/images/user.png',
			},
			{
				id: 2,
				imgProject: '/images/user.png',
			},
			{
				id: 3,
				imgProject: '/images/user.png',
			},
			{
				id: 4,
				imgProject: '/images/user.png',
			},
			{
				id: 5,
				imgProject: '/images/user.png',
			},
			{
				id: 6,
				imgProject: '/images/user.png',
			},
		],
	},
	{
		id: 3,
		nameProject: 'Cohorte',
		nameUser: 'Diego',
		imgProject: '/images/projects.jpg',
		members: [
			{
				id: 1,
				imgProject: '/images/user.png',
			},
			{
				id: 2,
				imgProject: '/images/user.png',
			},
		],
	},
];

export const guests = [
	// {
	// 	id: 3,
	// 	nameProject: 'Cohorte 23',
	// 	nameUser: 'Diego',
	// 	imgProject: '/images/projects.jpg',
	// 	nameProjectOwner: 'Sol Díaz',
	// 	members: [
	// 		{
	// 			id: 1,
	// 			imgProject: '/images/user.png',
	// 		},
	// 		{
	// 			id: 2,
	// 			imgProject: '/images/user.png',
	// 		},
	// 	],
	// },
];
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
