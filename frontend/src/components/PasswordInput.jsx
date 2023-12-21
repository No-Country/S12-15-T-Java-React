'use client';
import { useState } from 'react';
import '@/styles/passwordInput.css';
import styles from '@/styles/login.module.css';

const PasswordInput = ({ onChange, errors }) => {
	const [passwordVisible, setPasswordVisible] = useState(false);

	const togglePasswordVisibility = () => {
		setPasswordVisible(!passwordVisible);
	};

	return (
		<div className="container_password_input">
			<input
				type={passwordVisible ? 'text' : 'password'}
				id="password"
				name="password"
				onChange={onChange}
				placeholder="Introducir contraseña"
				className={errors?.password && styles.error_input}
			/>
			<span className="toggle_password" onClick={togglePasswordVisibility}>
				<img
					src={
						passwordVisible
							? '/images/eye-off-icon.png'
							: '/images/eye-on-icon.png'
					}
					alt="Toggle password visibility"
				/>
			</span>
		</div>
	);
};

export default PasswordInput;
