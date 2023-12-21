import AddCard from './AddCard';
import { BsThreeDots } from 'react-icons/bs';
import styleList from '@/styles/board/listBoard.module.css';
import styleCard from '@/styles/board/addCard.module.css';
import { disableTasks } from '@/app/api/board/route';
import { useState, useEffect, useRef } from 'react';

const ListBoard = ({ name, description, idTask, tasks, setTasks }) => {
	const [menuDeleteVisible, setMenuDeleteVisible] = useState(false);

	const handleDisableTask = async () => {
		setMenuDeleteVisible(!menuDeleteVisible);
		const newTasks = tasks.filter((task) => task.idTask !== idTask);
		setTasks(newTasks);
		await disableTasks(idTask);
	};

	const menuRef = useRef(null);
	useEffect(() => {
		const handleClickOutside = (event) => {
			if (menuRef.current && !menuRef.current.contains(event.target)) {
				setMenuDeleteVisible(false);
			}
		};

		document.addEventListener('click', handleClickOutside);
		return () => {
			document.removeEventListener('click', handleClickOutside);
		};
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	return (
		<main className={styleList.listBoard} id={idTask}>
			<header className={styleList.headerList}>
				<span className={styleList.listName}>{name ? name : description}</span>
				<button className={styleList.points} ref={menuRef}>
					<BsThreeDots
						onClick={() => setMenuDeleteVisible(!menuDeleteVisible)}
						className={styleList.threePoints}
					/>
				</button>
				{menuDeleteVisible && (
					<div
						className={styleList.menuDelete}
						onClick={() => handleDisableTask()}
					>
						Borrar
					</div>
				)}
			</header>
			<main className={styleCard.fixElementPlus}>
				<AddCard idTask={idTask} />
			</main>
		</main>
	);
};

export default ListBoard;
