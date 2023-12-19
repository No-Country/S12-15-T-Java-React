'use client';
import { useState } from 'react';
import { DndContext, closestCenter } from '@dnd-kit/core';
import {
	SortableContext,
	arrayMove,
	verticalListSortingStrategy,
} from '@dnd-kit/sortable';
import styleCard from '@/styles/board/addCard.module.css';
import { FaPlus } from 'react-icons/fa';
import { Card } from './Card';

const AddCard = () => {
	const [isEditing, setIsEditing] = useState(false);
	const [inputValue, setInputValue] = useState('');
	const [cards, setCards] = useState([
		{ id: 1, name: 'prueba' },
		{ id: 2, name: 'prueba2' },
		{ id: 3, name: 'prueba3' },
	]);

	const hableDragEnd = (event) => {
		const { active, over } = event;

		setCards((cards) => {
			const oldIndex = cards.findIndex((card) => card.id === active.id);
			const newIndex = cards.findIndex((card) => card.id === over.id);
			return arrayMove(cards, oldIndex, newIndex);
		});
	};

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
		<DndContext collisionDetection={closestCenter} onDragEnd={hableDragEnd}>
			<SortableContext items={cards} strategy={verticalListSortingStrategy}>
				<div className={styleCard.divCard}>
					{cards.map((card) => (
						<Card key={card.id} card={card} onClick={handleToggleEdit} />
					))}
				</div>
			</SortableContext>
			{isEditing ? (
				<div className={styleCard.enterName}>
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
		</DndContext>
	);
};

export default AddCard;
