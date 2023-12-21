'use client';
import { useEffect, useState } from 'react';
import { DndContext, closestCenter } from '@dnd-kit/core';
import {
	SortableContext,
	arrayMove,
	verticalListSortingStrategy,
} from '@dnd-kit/sortable';
import styleCard from '@/styles/board/addCard.module.css';
import { FaPlus } from 'react-icons/fa';
import { Card } from './Card';
import { getListActiviy, postActivity } from '@/app/api/board/route';

const AddCard = ({ idTask }) => {
	const user = localStorage.getItem('user');
	const userData = JSON.parse(user);
	const [isEditing, setIsEditing] = useState(false);
	const [inputValue, setInputValue] = useState('');
	const [cards, setCards] = useState([
		// { id: 1, name: 'prueba' },
		// { id: 2, name: 'prueba2' },
		// { id: 3, name: 'prueba3' },
	]);

	useEffect(() => {
		const fetchActivity = async () => {
			const dataActivity = await getListActiviy(idTask);
			console.log('DATA ACTIVITY', dataActivity);

			if (dataActivity !== undefined) {
				console.log('ENTRE');
				setCards((prevCards) => [...prevCards, ...dataActivity]);
			}
			// setCards((prevCards) => [...prevCards, ...dataActivity]);
		};

		fetchActivity();
	}, []);

	const hableDragEnd = (event) => {
		const { active, over } = event;
		// console.log('ACTIVE: ', active, 'OVER: ', over);
		setCards((cards) => {
			const oldIndex = cards.findIndex(
				(card) => card.idActivity === active.idActivity
			);
			const newIndex = cards.findIndex(
				(card) => card.idActivity === over.idActivity
			);
			return arrayMove(cards, oldIndex, newIndex);
		});
	};

	const handleToggleEdit = () => {
		setIsEditing(!isEditing);
	};

	const handleSave = async () => {
		if (inputValue.trim() !== '') {
			const tarea = inputValue;
			setInputValue('Subiendo tarea...');
			const responseActivity = await postActivity(idTask, tarea, userData.id);
			setCards([...cards, responseActivity]);
			setInputValue('');
			setIsEditing(false);
			// const newCard = { id: cards.length + 1, name: inputValue };
		}
	};

	const uniqueCards = cards.filter(
		(card, index, self) =>
			index === self.findIndex((c) => c.idActivity === card.idActivity)
	);

	return (
		<DndContext collisionDetection={closestCenter} onDragEnd={hableDragEnd}>
			<SortableContext
				items={uniqueCards}
				strategy={verticalListSortingStrategy}
			>
				<div className={styleCard.divCard}>
					{uniqueCards.map((card) => (
						<Card
							key={card.idActivity}
							card={card}
							onClick={handleToggleEdit}
						/>
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
