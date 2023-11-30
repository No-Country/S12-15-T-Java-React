'use client';

import { useState, useRef } from 'react';
import stylesRegister from '@/styles/register.module.css';

const Input = ({ type, name, placeholder }) => {
	const [showPassword, setShowPassword] = useState(false);
	const [error, setError] = useState('');
	const inputRef = useRef(null);

	const isPasswordInput = type === 'password';

	const togglePasswordVisibility = () => {
		setShowPassword((prev) => !prev);
	};

	//Verify the validity of the input field using the checkValidity method. If the field is not valid, set the error message according to the validation; if the field is valid, do not display the error message.
	const handleBlur = () => {
		const isValid = inputRef.current.checkValidity();
		if (!isValid) {
			setError(inputRef.current.validationMessage);
		} else {
			setError('');
		}
	};

	return (
		<>
			<div className={stylesRegister.boxInput}>
				<input
					type={isPasswordInput && showPassword ? 'text' : type}
					name={name}
					placeholder={placeholder}
					className={`${stylesRegister.input} ${error && stylesRegister.error}`}
					ref={inputRef}
					onBlur={handleBlur}
					required
				/>
				{isPasswordInput && (
					<svg
						xmlns="http://www.w3.org/2000/svg"
						width="22"
						height="16"
						viewBox="0 0 22 16"
						fill="none"
						className={stylesRegister.eyeicon}
						onClick={togglePasswordVisibility}
					>
						{showPassword ? (
							<path
								fillRule="evenodd"
								clipRule="evenodd"
								d="M11 0.5C6 0.5 1.73 3.61 0 8C1.73 12.39 6 15.5 11 15.5C16 15.5 20.27 12.39 22 8C20.27 3.61 16 0.5 11 0.5ZM11 13C8.24 13 6 10.76 6 8C6 5.24 8.24 3 11 3C13.76 3 16 5.24 16 8C16 10.76 13.76 13 11 13ZM11 5C9.34 5 8 6.34 8 8C8 9.66 9.34 11 11 11C12.66 11 14 9.66 14 8C14 6.34 12.66 5 11 5Z"
								fill="#42526E"
							/>
						) : (
							<path
								fillRule="evenodd"
								clipRule="evenodd"
								d="M11 0.5C6 0.5 1.73 3.61 0 8C1.73 12.39 6 15.5 11 15.5C16 15.5 20.27 12.39 22 8C20.27 3.61 16 0.5 11 0.5ZM11 13.5C7.21 13.5 3.83 11.37 2.18 8C3.83 4.63 7.21 2.5 11 2.5C14.79 2.5 18.17 4.63 19.82 8C18.17 11.37 14.79 13.5 11 13.5ZM11 3.5C8.52 3.5 6.5 5.52 6.5 8C6.5 10.48 8.52 12.5 11 12.5C13.48 12.5 15.5 10.48 15.5 8C15.5 5.52 13.48 3.5 11 3.5ZM11 10.5C9.62 10.5 8.5 9.38 8.5 8C8.5 6.62 9.62 5.5 11 5.5C12.38 5.5 13.5 6.62 13.5 8C13.5 9.38 12.38 10.5 11 10.5Z"
								fill="#42526E"
							/>
						)}
					</svg>
				)}
			</div>
			{error && <span className={stylesRegister.errorMessage}>{error}</span>}
		</>
	);
};

export default Input;
