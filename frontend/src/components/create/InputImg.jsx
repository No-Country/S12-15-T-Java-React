'use client';

import { useState } from 'react';
import styles from '@/styles/createworkspace.module.css';

const InputImg = () => {
	const [fileName, setFileName] = useState('');

	const handleFile = (e) => {
		const file = e.target.files[0];
		if (file) {
			setFileName(file.name);
		}
	};

	return (
		<label htmlFor="file-img" className={styles.input_img}>
			<span>Imagen principal:</span>
			<input
				type="text"
				value={fileName}
				readOnly
				onClick={() => document.getElementById('file-img').click()}
				placeholder="Seleccionar imagen..."
			/>
			<input
				type="file"
				id="file-img"
				name="file-img"
				className={styles.hidden}
				onChange={handleFile}
			/>
		</label>
	);
};

export default InputImg;
