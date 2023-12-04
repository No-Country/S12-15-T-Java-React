import stylesRegister from '@/styles/register.module.css';
import CardRegister from '@/components/CardRegister';

const Register = () => {
	return (
		<div className={stylesRegister.container}>
			<CardRegister />
		</div>
	);
};

export default Register;
