'use client';
import { useState } from 'react';
import styleList from '@/styles/board/listBoard.module.css';
import { FaPlus } from 'react-icons/fa';
import ListBoard from './ListBoard';

export const AddList = () => {
	const [isEditing, setIsEditing] = useState(false);
	const [inputValue, setInputValue] = useState('');
	const [list, setList] = useState([]);

	const handleEdit = () => {
		setIsEditing(!isEditing);
	};

	const handleSave = () => {
		console.log(inputValue);
		if (inputValue.trim() !== '') {
			setList([...list, inputValue]);
			setInputValue('');
			setIsEditing(false);
		}
	};

	return (
		<div className={styleList.newList}>
			<div className={styleList.newListBoard}>
				{list.map((listBoard, index) => (
					<div key={index}>
						<ListBoard name={listBoard} />
					</div>
				))}
			</div>
			{isEditing ? (
				<div className={styleList.enterName}>
					<input
						className={styleList.inputName}
						type="text"
						placeholder="Introduzca el titulo de la lista..."
						value={inputValue}
						onChange={(e) => setInputValue(e.target.value)}
					/>
					<button className={styleList.btnInput} onClick={handleSave}>
						Añadir lista
					</button>
				</div>
			) : (
				<div className={styleList.addList} onClick={handleEdit}>
					<FaPlus className={styleList.plus} />
					<span className={styleList.labelAddlist}>Añade otra lista</span>
				</div>
			)}
		</div>
	);
};
