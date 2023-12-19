'use client';
import { useEffect, useState } from 'react';
import { FaTrashAlt } from 'react-icons/fa';
import { MdOutlineTableRows } from 'react-icons/md';
import styleBoard from '@/styles/board/board.module.css';
import Image from 'next/image';
import ListBoard from '@/components/board/ListBoard';
import { AddList } from '@/components/board/AddList';
import { getTasks } from '@/app/api/workspace/board/boardApi';

const Boardpage = ({ params }) => {
	const [tasks, setTasks] = useState([]);
	const { idBoard } = params;

	useEffect(() => {
		const fetchTasks = async () => {
			try {
				const response = await getTasks(idBoard);
				setTasks(response.data);
			} catch (error) {
				console.error('Error fetching task columns data:', error);
			}
		};

		fetchTasks();
	}, [idBoard]);

	return (
		<div className={styleBoard.board}>
			<header className={styleBoard.header}>
				<div className={styleBoard.headerName}>
					<MdOutlineTableRows className={styleBoard.iconBoard} />
					<span className={styleBoard.nameBoard}>Nombre tablero</span>
				</div>
				<div className={styleBoard.headerUsers}>
					<span className={styleBoard.numberUser}>124</span>
					<Image
						src="/images/rectangle-user-icon.png"
						width={35}
						height={35}
						alt="iconBoard"
					/>
					<button className={styleBoard.btnTrash}>
						<FaTrashAlt className={styleBoard.trash} />
					</button>
				</div>
			</header>
			<main className={styleBoard.tableBoard}>
				{tasks &&
					tasks.map((task) => (
						<ListBoard
							key={task.idTask}
							task={task}
							tasks={tasks}
							setTasks={setTasks}
						/>
					))}

				<AddList setTasks={setTasks} idBoard={idBoard} />
			</main>
		</div>
	);
};

export default Boardpage;
