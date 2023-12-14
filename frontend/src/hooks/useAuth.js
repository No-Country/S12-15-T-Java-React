'use client';
import { useState } from 'react';
// eslint-disable-next-line no-undef
const apiUrl = process.env.NEXT_PUBLIC_API_URL;

const useAuth = () => {
	const [user, setUser] = useState(null);
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(null);

	const login = async (credentials) => {
		setLoading(true);
		setError(null);

		console.log(`${apiUrl}/auth/login`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(credentials),
		});

		try {
			const response = await fetch(`${apiUrl}/auth/login`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(credentials),
			});

			if (response.ok) {
				const user = await response.json();
				localStorage.setItem('user', JSON.stringify(user));
				localStorage.setItem('token', user.token);
				setUser(user);
				window.location.href = `/login/${user.id}/home/`;
			} else {
				console.log('Error: ' + response.status);
				setError('Error al iniciar sesión, intente nuevamente.');
			}
		} catch (error) {
			console.error('Error en la autenticación:', error);
			setError('Error al iniciar sesión, intente nuevamente.');
		} finally {
			setLoading(false);
		}
	};

	const logout = () => {
		setUser(null);
	};

	return { user, loading, error, login, logout };
};

export default useAuth;
