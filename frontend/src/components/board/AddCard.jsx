'use client';
import { useState } from 'react';
import { FaPlus } from 'react-icons/fa';

const AddCard = () => {
	const [isEditing, setIsEditing] = useState(false);
	const [inputValue, setInputValue] = useState('');
	const [cards, setCards] = useState([]);

	const handleToggleEdit = () => {
		setIsEditing(!isEditing);
	};

	const handleSave = () => {
		if (inputValue.trim() !== '') {
			setCards([...cards, inputValue]);
			setInputValue('');
			setIsEditing(false);
		}
	};

	return (
		<div>
			{/* Muestra las tarjetas */}
			{cards.map((card, index) => (
				<div key={index} onClick={() => setIsEditing(!isEditing)}>
					{card}
				</div>
			))}

			{isEditing ? (
				<div>
					{/* Contenido del formulario de edición */}
					<input
						type="text"
						placeholder="Agregar elemento"
						value={inputValue}
						onChange={(e) => setInputValue(e.target.value)}
					/>
					<button onClick={handleSave}>Guardar</button>
				</div>
			) : (
				<div>
					{/* Contenido normal antes de hacer clic */}
					<div onClick={handleToggleEdit}>
						<FaPlus /> Agregar elemento
					</div>
				</div>
			)}
		</div>
	);
};

export default AddCard;
