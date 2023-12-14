import styles from '@/styles/login.module.css';
import Link from 'next/link';
import PasswordInput from '../../components/PasswordInput';
const LoginPage = () => {
	return (
		<div className={styles.container_login}>
			<form className={styles.container_form}>
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
					<input type="email" placeholder="Introducir email" />
					<PasswordInput />
				</div>
				<div className={styles.container_buttons}>
					<button type="submit" className={styles.blue_button}>
						Inciar Sesión
					</button>
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
						<Link href="">Crear cuenta</Link> <hr />
						<Link href="">Recuperar contraseña</Link>
					</div>
				</div>
			</form>
		</div>
	);
};

export default LoginPage;
