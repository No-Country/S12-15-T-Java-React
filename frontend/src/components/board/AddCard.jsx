'use client';
import { useState } from 'react';
import styleCard from '@/styles/board/addCard.module.css';
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
				<div
					key={index}
					className={styleCard.card}
					onClick={() => setIsEditing(!isEditing)}
				>
					<span className={styleCard.cardName}>{card}</span>
				</div>
			))}

			{isEditing ? (
				<div className={styleCard.enterName}>
					{/* Contenido del formulario de edición */}
					<textarea
						className={styleCard.textAreaName}
						type="text"
						placeholder="Introduzca un titulo para esta tarjeta..."
						value={inputValue}
						onChange={(e) => setInputValue(e.target.value)}
					/>
					<button className={styleCard.btnTextArea} onClick={handleSave}>
						Añadir tarjeta
					</button>
				</div>
			) : (
				<div onClick={handleToggleEdit} className={styleCard.elementPlus}>
					<FaPlus className={styleCard.plus} />
					<span className={styleCard.nameElementPlus}>Añadir una tarjeta</span>
				</div>
			)}
		</div>
	);
};

export default AddCard;
