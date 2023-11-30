import Link from 'next/link';
import Logo from '@/components/Logo';
import FormRegister from './FormRegister';
import BtnGoogle from '@/components/BtnGoogle';
import stylesRegister from '@/styles/register.module.css';

const CardRegister = () => {
	return (
		<div className={stylesRegister.card}>
			<Logo />
			<FormRegister />
			<div className={stylesRegister.lineBox}>
				<div className={stylesRegister.line}></div>O BIEN
				<div className={stylesRegister.line}></div>
			</div>
			<BtnGoogle>Registrarme con Google</BtnGoogle>
			<hr className={stylesRegister.hr} />
			<Link href="/login" className={stylesRegister.loginLink}>
				Ya tengo cuenta
			</Link>
		</div>
	);
};

export default CardRegister;
