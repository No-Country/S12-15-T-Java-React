// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;
const token = localStorage.getItem('token');

export const getWorkspaceData = async (idWorkspace) => {
	try {
		const response = await fetch(`${apiUrl}/space/${idWorkspace}`, {
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error en la petición' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error en la petición' };
	}
};

export const getChannels = async (idWorkspace) => {
	try {
		const response = await getWorkspaceData(idWorkspace); //temporary until the specific endpoint is ready.
		if (response.success) {
			return { success: true, data: response.data.channels };
		} else {
			return { success: false, error: 'Error fetching channels data:' };
		}
	} catch (error) {
		console.log(error);
	}
};

export const getBoards = async (idWorkspace) => {
	try {
		const response = await fetch(
			`${apiUrl}/space/listOfEnabledBoardsByIdSpace/${idWorkspace}`,
			{
				headers: {
					Authorization: `Bearer ${token}`,
					'Content-Type': 'application/json',
				},
			}
		);
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error fetching boards data:' };
		}
	} catch (error) {
		console.log(error);
	}
};
