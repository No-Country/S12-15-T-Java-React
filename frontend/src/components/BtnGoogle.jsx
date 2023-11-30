import stylesRegister from '@/styles/register.module.css';

const BtnGoogle = ({ children }) => {
	return (
		<button className={stylesRegister.btnGoogle}>
			<img src="/images/logo-Google.png" />
			{children}
		</button>
	);
};

export default BtnGoogle;
