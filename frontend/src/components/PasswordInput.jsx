'use client';
import { useState } from 'react';
import '@/styles/passwordInput.css';
const PasswordInput = () => {
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
				placeholder="Introducir contraseña"
			/>
			<span className="toggle_password" onClick={togglePasswordVisibility}>
				<img
					src={
						passwordVisible
							? '/images/eye-off-icon.png'
							: 'images/eye-on-icon.png'
					}
					alt="Toggle password visibility"
				/>
			</span>
		</div>
	);
};

export default PasswordInput;
