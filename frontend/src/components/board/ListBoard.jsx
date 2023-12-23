import AddCard from './AddCard';
import { BsThreeDots } from 'react-icons/bs';
import styleList from '@/styles/board/listBoard.module.css';
import styleCard from '@/styles/board/addCard.module.css';
import { disableTasks } from '@/app/api/board/route';
import { useState } from 'react';

const ListBoard = ({ name, description, idTask, tasks, setTasks }) => {
	const [menuDeleteVisible, setMenuDeleteVisible] = useState(false);

	const handleDisableTask = async () => {
		setMenuDeleteVisible(!menuDeleteVisible);
		const newTasks = tasks.filter((task) => task.idTask !== idTask);
		setTasks(newTasks);
		await disableTasks(idTask);
	};

	return (
		<main className={styleList.listBoard} id={idTask}>
			<header className={styleList.headerList}>
				<span className={styleList.listName}>{name ? name : description}</span>
				<button className={styleList.points}>
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
				<AddCard />
			</main>
		</main>
	);
};

export default ListBoard;
