const Button = ({ children, ...props }) => {
	return (
		<button {...props} type={props.type} disabled={props.disabled}>
			{children}
		</button>
	);
};

export default Button;
