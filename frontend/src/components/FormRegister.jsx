'use client';

import stylesRegister from '@/styles/register.module.css';
import Input from '@/components/Input';
import Button from '@/components/ButtonRegister';

function FormRegister() {
	return (
		<form className={stylesRegister.form} action="/home" method="POST">
			<h3 className={stylesRegister.title}>Regístrate para continuar</h3>
			<div className={stylesRegister.inputs}>
				<Input type="text" name="name" placeholder="Nombre de usuario" />
				<Input
					type="email"
					name="email"
					placeholder="Introduce tu correo electrónico"
				/>
				<Input
					type="password"
					name="password"
					placeholder="Introducir contraseña"
				/>
				<Input
					type="password"
					name="password"
					placeholder="Repetir contraseña"
				/>
			</div>
			<Button>Registrarme</Button>
		</form>
	);
}

export default FormRegister;
