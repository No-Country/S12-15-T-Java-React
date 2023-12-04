import stylesRegister from '@/styles/register.module.css';

const Button = ({ children, ...props }) => {
	return (
		<button {...props} className={stylesRegister.button}>
			{children}
		</button>
	);
};

export default Button;
