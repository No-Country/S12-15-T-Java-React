'use client';
import { useState } from 'react';
import styleList from '@/styles/board/listBoard.module.css';
import { FaPlus } from 'react-icons/fa';
// import ListBoard from './ListBoard';
import { postListTask } from '@/app/api/board/route';

export const AddList = ({ idBoard, setTask }) => {
	const [isEditing, setIsEditing] = useState(false);
	const [inputValue, setInputValue] = useState('');
	// const [list, setList] = useState([]);

	const handleEdit = () => {
		setIsEditing(!isEditing);
	};

	const handleSave = async () => {
		console.log(inputValue);
		if (inputValue.trim() !== '') {
			setInputValue('');
			setIsEditing(false);
			const responsePostList = await postListTask(idBoard, inputValue);
			console.log('RESPUESTA', responsePostList);
			setTask((prevTask) => [...prevTask, responsePostList]);
			// setList([...list, inputValue]);
		}
	};

	return (
		<div className={styleList.newList}>
			{/* <div className={styleList.newListBoard}>
				{list.map((listBoard,index) => (
					<div key={index}>
						<ListBoard name={inputValue} description={listBoard.description}/>
					</div>
				))}
			</div> */}
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
