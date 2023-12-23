'use client';

import { useState } from 'react';
import { useRouter } from 'next/navigation';
import stylesRegister from '@/styles/register.module.css';
import Input from '@/components/register/Input';
import Button from '@/components/Button';
import InputPasswordsConfirm from './InputPasswordsConfirm';
import { registerUser } from '@/app/api/register/registerApi';

function FormRegister() {
	const [name, setName] = useState('');
	const [lastName, setLastName] = useState('');
	const [username, setUserName] = useState('');
	const [email, setEmail] = useState('');
	const [passwords, setPasswords] = useState({
		password: '',
		confirmPassword: '',
	});

	const [loading, setLoading] = useState(false);
	const [registrationStatus, setRegistrationStatus] = useState({
		success: null,
		message: null,
	});

	const router = useRouter();

	const handleSubmit = async (e) => {
		e.preventDefault();
		setLoading(true);

		try {
			const { success, id, error } = await registerUser(
				name,
				lastName,
				username,
				email,
				passwords.password,
				passwords.confirmPassword
			);

			if (success) {
				setRegistrationStatus({ success: true, message: 'Registro exitoso' });
				setTimeout(() => {
					setRegistrationStatus({ success: null, message: null });
					router.push(`/login/${id}/home`);
				}, 2000);
				console.log('Registro exitoso');
			} else {
				setRegistrationStatus({ success: false, message: `Error: ${error}` });
				console.error(error);
			}
		} catch (error) {
			console.error(error);
			setRegistrationStatus({
				success: false,
				message: 'Error en la petición',
			});
		}

		setLoading(false);

		setName('');
		setLastName('');
		setUserName('');
		setEmail('');
		setPasswords({ password: '', confirmPassword: '' });
	};
	return (
		<form className={stylesRegister.form_register} onSubmit={handleSubmit}>
			<h3 className={stylesRegister.title}>Regístrate para continuar</h3>
			<div className={stylesRegister.inputs}>
				<Input
					type="text"
					id="name"
					name="name"
					placeholder="Introduce tu nombre"
					value={name}
					setInput={setName}
				/>
				<Input
					type="text"
					id="lastname"
					name="lastname"
					placeholder="Introduce tu apellido"
					value={lastName}
					setInput={setLastName}
				/>
				<Input
					type="text"
					id="username"
					name="username"
					placeholder="Nombre de usuario"
					value={username}
					setInput={setUserName}
				/>
				<Input
					type="email"
					id="email"
					name="email"
					placeholder="Introduce tu correo electrónico"
					value={email}
					setInput={setEmail}
				/>
				<InputPasswordsConfirm
					passwords={passwords}
					setPasswords={setPasswords}
				/>
			</div>
			<Button
				className={stylesRegister.button}
				type="submit"
				disabled={loading}
			>
				{loading ? 'Cargando...' : 'Registrarme'}
			</Button>
			{registrationStatus.success !== null && (
				<div
					className={
						registrationStatus.success
							? stylesRegister.successfulmessage
							: stylesRegister.unsuccessfulmessage_error
					}
				>
					{registrationStatus.message}
				</div>
			)}
		</form>
	);
}

export default FormRegister;
