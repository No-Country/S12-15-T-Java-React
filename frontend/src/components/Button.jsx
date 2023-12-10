const Button = ({ children, ...props }) => {
	return (
		<button {...props} type={props.type}>
			{children}
		</button>
	);
};

export default Button;
