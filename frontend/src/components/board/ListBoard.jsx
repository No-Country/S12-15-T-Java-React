import AddCard from './AddCard';
import { BsThreeDots } from 'react-icons/bs';
import styleList from '@/styles/board/listBoard.module.css';
import styleCard from '@/styles/board/addCard.module.css';
import { useState } from 'react';
import { disableTasks } from '@/app/api/workspace/board/boardApi';

const ListBoard = ({ task, tasks, setTasks }) => {
	const { idTask = '', name, description } = task || {}; //ver de recibir id de la task recien creada por si se quiere borrar
	const [menuDeleteVisible, setMenuDeleteVisible] = useState(false);

	const handleDisableTask = async () => {
		const response = await disableTasks(idTask);
		if (response.success) {
			const newTasks = tasks.filter((task) => task.idTask !== idTask);
			setTasks(newTasks);
		}
	};
	return (
		<main className={styleList.listBoard} id={idTask}>
			<header className={styleList.headerList}>
				{/*Backend is temporary using description as name */}
				<span className={styleList.listName}>{name ? name : description}</span>
				<button className={styleList.points}>
					<BsThreeDots
						className={styleList.threePoints}
						onClick={() => setMenuDeleteVisible(!menuDeleteVisible)}
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
				<AddCard />
			</main>
		</main>
	);
};

export default ListBoard;
