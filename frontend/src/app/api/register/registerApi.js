// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

export async function registerUser(name, email, password, repeatedPassword) {
	try {
		const response = await fetch(
			`${apiUrl}/auth/register`,
			{
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					username: name,
					email,
					password,
					repeatedPassword,
				}),
			}
		);

		if (response.ok) {
			const data = await response.json();
			return { success: true, id: data.id };
		} else {
			const errorData = await response.json();
			console.error(errorData);
			return { success: false, error: errorData };
		}
	} catch (error) {
		console.error(error);
		return { success: false, error: 'Error en la petición' };
	}
  }