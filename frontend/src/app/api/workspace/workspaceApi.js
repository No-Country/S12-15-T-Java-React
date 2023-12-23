// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export const getWorkspaceData = async (idWorkspace) => {
	const token = localStorage.getItem('token');
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
			return { success: false, error: 'Error fetching workspace data:' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error fetching workspace data:' };
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
	const token = localStorage.getItem('token');
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

export const createChannel = async (idWorkspace, name) => {
	const token = localStorage.getItem('token');
	try {
		const response = await fetch(`${apiUrl}/channel/new/${idWorkspace}`, {
			method: 'POST',
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ nameChannel: name }),
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error creating new channel:' };
		}
	} catch (error) {
		console.log(error);
	}
};

export const createBoard = async (idWorkspace, name) => {
	const token = localStorage.getItem('token');
	try {
		const response = await fetch(`${apiUrl}/board/register/${idWorkspace}`, {
			method: 'POST',
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ boardName: name }),
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error creating new board:' };
		}
	} catch (error) {
		console.log(error);
	}
};

export const getChannelData = async (idChannel) => {
	const token = localStorage.getItem('token');
	try {
		const response = await fetch(`${apiUrl}/channel/${idChannel}`, {
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error fetching channel data:' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error fetching channel data:' };
	}
};
