const BtnGoogle = ({ children, ...props }) => {
	return (
		<button {...props}>
			<img src="/images/logo-Google.png" />
			{children}
		</button>
	);
};

export default BtnGoogle;
