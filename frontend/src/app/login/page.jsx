'use client';
import { useState } from 'react';
import styles from '@/styles/login.module.css';
import Link from 'next/link';
import PasswordInput from '../../components/PasswordInput';
import useAuth from '@/hooks/useAuth';

const LoginPage = () => {
	const { login, loading, error } = useAuth();
	const [formData, setFormData] = useState({
		email: '',
		password: '',
	});

	const [errors, setErrors] = useState({
		email: '',
		password: '',
	});

	const validateEmail = (email) => {
		const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		return emailRegex.test(email);
	};

	const validatePassword = (password) => {
		const passwordRegex = /^[a-zA-Z0-9]{3,16}$/;
		return passwordRegex.test(password);
	};

	const handleInputChange = (e) => {
		const { name, value } = e.target;

		setFormData({
			...formData,
			[name]: value,
		});

		// Clean input error after type again
		setErrors({
			...errors,
			[name]: '',
		});
	};

	const handleSubmit = async (e) => {
		e.preventDefault();

		const { email, password } = formData;

		// Email validation
		if (!validateEmail(email)) {
			setErrors((prevErrors) => ({
				...prevErrors,
				email: 'Correo electrónico inválido',
			}));
		}
		//Password validation
		if (!validatePassword(password)) {
			setErrors((prevErrors) => ({
				...prevErrors,
				password: 'Contraseña inválida',
			}));
		}

		//Procede to login
		if (validateEmail(email) && validatePassword(password)) {
			await login(formData);
		}
	};

	return (
		<div className={styles.container_login}>
			<form className={styles.container_form} onSubmit={handleSubmit}>
				<div className={styles.container_logo}>
					<img
						src="/images/logo-logo.png"
						alt="Track logo"
						className={styles.img_logo}
					/>
					<span className={styles.text_logo}>Track</span>
				</div>
				<span className={styles.subtitle}>Inicia sesión para continuar</span>
				<div className={styles.container_inputs}>
					<div>
						<input
							type="text"
							placeholder="Introducir email"
							name="email"
							value={formData.email}
							onChange={handleInputChange}
							className={errors.email && styles.error_input}
						/>
						{errors.email && (
							<span className={styles.error_message}>{errors.email}</span>
						)}
					</div>
					<div>
						<PasswordInput onChange={handleInputChange} errors={errors} />
						{errors.password && (
							<span className={styles.error_message}>{errors.password}</span>
						)}
					</div>
				</div>
				<div className={styles.container_buttons}>
					<button
						type="submit"
						className={styles.blue_button}
						disabled={loading}
					>
						{loading ? 'Cargando...' : 'Iniciar Sesión'}
					</button>
					{error && <span className={styles.error_login}>{error}</span>}
					<div className={styles.divider}>
						<hr />
						<span>O BIEN</span>
						<hr />
					</div>
					<button className={styles.google_button}>
						<img src="/images/google-logo.png" alt="Google logo" />
						Continuar con Google
					</button>
				</div>
				<div className={styles.bottom_menu_container}>
					<hr />
					<div className={styles.bottom_menu}>
						<Link href="/register">Crear cuenta</Link> <hr />
						<Link href="">Recuperar contraseña</Link>
					</div>
				</div>
			</form>
		</div>
	);
};

export default LoginPage;
