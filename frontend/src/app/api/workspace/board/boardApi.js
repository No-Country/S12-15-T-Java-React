// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;
const token = localStorage.getItem('token');

export const getTasks = async (idBoard) => {
	try {
		const response = await fetch(
			`${apiUrl}/board/listOfEnabledTasksByIdBoard/${idBoard}`,
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
			return { success: false, error: 'Error fetching task colums data:' };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error fetching task colums data:' };
	}
};

export const newTasks = async (idBoard, task) => {
	console.log(`${apiUrl}/task/new/${idBoard}`, task);
	try {
		const response = await fetch(`${apiUrl}/task/new/${idBoard}`, {
			method: 'POST',
			headers: {
				Authorization: `Bearer ${token}`,
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ description: task }), //backend is temporary using description as name
		});
		if (response.ok) {
			const data = await response.json();
			return { success: true, data };
		} else {
			return { success: false, error: 'Error fetching new task column:' };
		}
	} catch (error) {
		console.error('Error fetching new task column:', error);
	}
};

export const disableTasks = async (task) => {
	try {
		const response = await fetch(`${apiUrl}/task/disable/${task}`, {
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
