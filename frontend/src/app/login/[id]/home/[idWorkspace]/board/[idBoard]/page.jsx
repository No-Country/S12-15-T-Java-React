'use client';
import { FaTrashAlt } from 'react-icons/fa';
import { MdOutlineTableRows } from 'react-icons/md';
import styleBoard from '@/styles/board/board.module.css';
import Image from 'next/image';
import ListBoard from '@/components/board/ListBoard';
import { AddList } from '@/components/board/AddList';
import { useEffect, useState } from 'react';
import { getFindBoard, getTaskList } from '@/app/api/board/route';
import withAuth from '@/lib/withAuth';

const Boardpage = ({ params }) => {
	const { idBoard } = params;
	const [tasks, setTasks] = useState([]);
	const [nameBoard, setNameBoard] = useState();

	useEffect(() => {
		const fetchTask = async () => {
			try {
				const newTask = await getTaskList(idBoard);
				const { boardName } = await getFindBoard(idBoard);
				setNameBoard(boardName);
				setTasks(newTask);
			} catch (error) {
				console.error('Error' + error);
			}
		};
		fetchTask();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	return (
		<div className={styleBoard.board}>
			<header className={styleBoard.header}>
				<div className={styleBoard.headerName}>
					<MdOutlineTableRows className={styleBoard.iconBoard} />
					<span className={styleBoard.nameBoard}>
						{nameBoard === 'Demo Board' ? 'General' : nameBoard}
					</span>
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
			<main className={`${styleBoard.tableBoard}`}>
				{tasks.map((task) => (
					<div key={task.idTask}>
						<ListBoard
							name={task.name}
							description={task.description}
							idTask={task.idTask}
							tasks={tasks}
							setTasks={setTasks}
						/>
					</div>
				))}
				<AddList idBoard={idBoard} setTask={setTasks} />
			</main>
		</div>
	);
};

const ProtectBoardAuth = withAuth(Boardpage);

export default ProtectBoardAuth;
