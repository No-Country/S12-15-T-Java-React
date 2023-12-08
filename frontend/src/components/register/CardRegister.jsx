import Link from 'next/link';
import Logo from '@/components/Logo';
import FormRegister from './FormRegister';
import BtnGoogle from '@/components/BtnGoogle';
import stylesRegister from '@/styles/register.module.css';

const CardRegister = () => {
	return (
		<div className={stylesRegister.card_register}>
			<Logo />
			<FormRegister />
			<div className={stylesRegister.boxDivider}>
				<div className={stylesRegister.divider}></div>O BIEN
				<div className={stylesRegister.divider}></div>
			</div>
			<BtnGoogle className={stylesRegister.btnGoogle}>
				Registrarme con Google
			</BtnGoogle>
			<hr className={stylesRegister.hr} />
			<Link href="/login" className={stylesRegister.loginLink}>
				Ya tengo cuenta
			</Link>
		</div>
	);
};

export default CardRegister;
