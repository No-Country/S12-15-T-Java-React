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
	const [email, setEmail] = useState('');
	const [passwords, setPasswords] = useState({
		password: '',
		confirmPassword: '',
	});
	const router = useRouter();

	const handleSubmit = async (e) => {
		e.preventDefault();

		const { success, id, error } = await registerUser(
			name,
			email,
			passwords.password,
			passwords.confirmPassword
		);

		if (success) {
			router.push(`/login/${id}/home`);
			console.log('Registro exitoso');
		} else {
			console.error(error);
		}

		setName('');
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
					placeholder="Nombre de usuario"
					value={name}
					setInput={setName}
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
			<Button className={stylesRegister.button} type="submit">
				Registrarme
			</Button>
		</form>
	);
}

export default FormRegister;
