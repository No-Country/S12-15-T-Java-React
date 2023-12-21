import stylesRegister from '@/styles/register.module.css';
import CardRegister from '@/components/register/CardRegister';

const Register = () => {
	return (
		<div className={stylesRegister.container_register}>
			<CardRegister />
		</div>
	);
};

export default Register;
