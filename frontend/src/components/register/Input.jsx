'use client';

import { useState, useRef } from 'react';
import stylesRegister from '@/styles/register.module.css';

const Input = ({ type, name, placeholder, value, setInput }) => {
	const [error, setError] = useState('');
	const inputRef = useRef(null);

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
					type={type}
					name={name}
					placeholder={placeholder}
					className={`${stylesRegister.input} ${error && stylesRegister.error}`}
					ref={inputRef}
					value={value}
					onChange={(e) => {
						setInput(e.target.value);
					}}
					onBlur={handleBlur}
					required
				/>
			</div>
			{error && <span className={stylesRegister.errorMessage}>{error}</span>}
		</>
	);
};

export default Input;
