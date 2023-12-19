'use client';

import { useState } from 'react';
import stylesModal from '@/styles/popup.module.css';
import { FaPlus } from 'react-icons/fa';
import { FaTrashAlt } from 'react-icons/fa';
import { IoClose } from 'react-icons/io5';

const Checklist = () => {
	const [inputValue, setInputValue] = useState('');
	const [items, setItems] = useState([]);
	const [inputAddCheckVisible, setInputAddCheckVisible] = useState(false);

	const handleInputChange = (e) => {
		setInputValue(e.target.value);
	};

	const handleAddItem = () => {
		if (inputValue.trim() !== '') {
			setItems([...items, { text: inputValue, checked: false }]);
			setInputValue('');
			setInputAddCheckVisible(!inputAddCheckVisible);
		}
	};

	const handleToggleCheck = (index) => {
		const updatedItems = [...items];
		updatedItems[index].checked = !updatedItems[index].checked;
		setItems(updatedItems);
	};

	const handleDeleteItem = (index) => {
		const updatedItems = [...items];
		updatedItems.splice(index, 1);
		setItems(updatedItems);
	};

	const handleToggleCheckVisibility = () => {
		setInputAddCheckVisible(!inputAddCheckVisible);
	};

	return (
		<>
			<ul className={stylesModal.checklist}>
				{items.map((item, index) => (
					<li key={index} className={stylesModal.checklist_item}>
						<div className={stylesModal.checkbox_text}>
							<input
								type="checkbox"
								checked={item.checked}
								onChange={() => handleToggleCheck(index)}
							/>
							{item.text}
						</div>
						<button
							className={stylesModal.btn_trash}
							onClick={() => handleDeleteItem(index)}
						>
							<FaTrashAlt />
						</button>
					</li>
				))}
			</ul>
			<div
				className={stylesModal.check_input}
				style={{ display: inputAddCheckVisible ? 'flex' : 'none' }}
			>
				<button className={stylesModal.addcheck} onClick={handleAddItem}>
					<FaPlus />
					&nbsp;&nbsp;Agregar Check
				</button>
				<input
					type="text"
					value={inputValue}
					onChange={handleInputChange}
					placeholder="Escribe un ítem"
				/>
				<IoClose onClick={handleToggleCheckVisibility} />
			</div>
			<button
				className={stylesModal.addcheck}
				style={{ display: inputAddCheckVisible ? 'none' : 'flex' }}
				onClick={handleToggleCheckVisibility}
			>
				<FaPlus />
				&nbsp;&nbsp;Agregar Check
			</button>
		</>
	);
};

export default Checklist;
