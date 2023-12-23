'use client';
import { useEffect, useState } from 'react';
import '@/styles/activity.css';
import Link from 'next/link';
import {
	getChannels,
	getBoards,
	getWorkspaceData,
	createBoard,
	createChannel,
} from '@/app/api/workspace/workspaceApi';

export const Aside = ({ params }) => {
	let user;
	if (typeof window !== 'undefined')
		user = JSON.parse(localStorage.getItem('user'));
	const [workspace, setWorkspace] = useState({
		name: '',
	});
	const [channels, setChannels] = useState([]);
	const [boards, setBoards] = useState([]);
	const { idWorkspace } = params;
	const [addChanelInput, setAddChanelInput] = useState(false);
	const [addBoardInput, setAddBoardInput] = useState(false);
	const [newChannelName, setNewChannelName] = useState('');
	const [newBoardName, setNewBoardName] = useState('');

	const handleSubmitNewChannel = async () => {
		if (newChannelName != '') {
			try {
				const response = await createChannel(idWorkspace, newChannelName);

				if (response.success) {
					setChannels((prevChannels) => [
						...prevChannels,
						{
							idChannel: response.data.idChannel,
							nameChannel: response.data.nameChannel,
						},
					]);

					setAddChanelInput(false);
					setNewChannelName('');
				} else {
					alert('Debe elegir un nombre para el canal');
				}
			} catch (error) {
				console.error('An unexpected error occurred:', error);
			}
		} else {
			alert('Debe elegir un nombre para el canal');
		}
	};
	const handleSubmitNewBoard = async () => {
		if (newBoardName !== '') {
			try {
				const response = await createBoard(idWorkspace, newBoardName);

				if (response.success) {
					setBoards((prevBoards) => [
						...prevBoards,
						{
							idBoard: response.data.idBoard,
							boardName: response.data.boardName,
						},
					]);

					setAddBoardInput(false);
					setNewBoardName('');
				} else {
					alert('Debe elegir un nombre para el tablero');
				}
			} catch (error) {
				console.error('An unexpected error occurred:', error);
				alert('Error creando nuevo tablero');
			}
		} else {
			alert('Debe elegir un nombre para el tablero');
		}
	};

	useEffect(() => {
		const fetchWorkspace = async () => {
			try {
				const workspaceData = await getWorkspaceData(idWorkspace);
				if (workspaceData.success) {
					setWorkspace({ name: workspaceData.data.name });
				} else {
					console.error('Error fetching workspace data:', workspaceData.error);
				}
			} catch (error) {
				console.error(
					'An unexpected error occurred while fetching workspace data:',
					error
				);
			}
		};

		const fetchChannels = async () => {
			try {
				const channelsData = await getChannels(idWorkspace);
				if (channelsData.success) {
					setChannels(channelsData.data);
				} else {
					console.error('Error fetching channels data:', channelsData.error);
				}
			} catch (error) {
				console.error(
					'An unexpected error occurred while fetching channels data:',
					error
				);
			}
		};

		const fetchBoards = async () => {
			try {
				const boardsData = await getBoards(idWorkspace);
				if (boardsData.success) {
					setBoards(boardsData.data);
				} else {
					console.error('Error fetching boards data:', boardsData.error);
				}
			} catch (error) {
				console.error(
					'An unexpected error occurred while fetching boards data:',
					error
				);
			}
		};

		fetchWorkspace();
		fetchChannels();
		fetchBoards();
	}, [idWorkspace]);
	useEffect(() => {
		const btnToggle = document.querySelector('.toggle-btn');
		const sidebar = document.getElementById('sidebar');

		const handleClick = () => {
			console.log('clic');
			sidebar.classList.toggle('activos');
			console.log(document.getElementById('sidebar'));
		};

		if (btnToggle && sidebar) {
			btnToggle.addEventListener('click', handleClick);
		}

		// Limpia el evento al desmontar el componente
		return () => {
			if (btnToggle) {
				btnToggle.removeEventListener('click', handleClick);
			}
		};
	}, []);
	return (
		<aside id="sidebar" className="white-link">
			{/* <div className="frame-766 toggle-btn">
				<div className=" vector2">
					<img src="/images/Vector2.png" alt="Texto alternativo de la imagen" />
				</div>
			</div> */}
			<div className="barra-lateral-tablero">
				<div className="frame-736">
					<div className="nombre-del-proyecto-en-el-caso-de-ser-mas-largo-se-acorta-ahi">
						{workspace.name}
					</div>
					<div className="icono-config" width="20" height="20">
						<div>
							<img
								src="/images/IconoConfig.png"
								alt="Texto alternativo de la imagen"
							/>
						</div>
					</div>
				</div>

				<div className="frame-737">
					<div className="frame-748">
						<div className="seccion-tablero">
							<img
								src="/images/Vector.png"
								alt="Texto alternativo de la imagen"
							/>

							<div className="canales-comunicaci-n">
								Canales de comunicación
							</div>
						</div>
						<div className="frame-749">
							{channels.map((channel) => (
								<div
									className="canales-tablero-agregar"
									key={channel.idChannel}
								>
									<div className="icono-chat" width="16" height="16">
										<img
											src="/images/Icono_chat.png"
											alt="Texto alternativo de la imagen"
										/>
									</div>
									<div className="nombre">
										<Link
											href={`/login/${user.id}/home/${idWorkspace}/channel/${channel.idChannel}`}
										>
											{channel.nameChannel == 'Demo nameChannel'
												? 'General'
												: channel.nameChannel}
										</Link>
									</div>
								</div>
							))}

							<div className="canales-tablero-agregar2">
								<div className="icono-agregar" width="16" height="16">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								{addChanelInput ? (
									<div className="add_new">
										<input
											type="text"
											placeholder="Escribe el nombre"
											value={newChannelName}
											onChange={(e) => setNewChannelName(e.target.value)}
										></input>
										<div>
											<button onClick={handleSubmitNewChannel}>Crear</button>
											<button
												onClick={() => {
													setNewChannelName('');
													setAddChanelInput(false);
												}}
											>
												Cancelar
											</button>
										</div>
									</div>
								) : (
									<div
										className="nombre"
										onClick={() => setAddChanelInput(true)}
									>
										Agregar Canal
									</div>
								)}
							</div>
						</div>
					</div>
				</div>
				<div className="frame-738">
					<div className="frame-7492">
						<div className="seccion-tablero">
							<img
								src="/images/Vector.png"
								alt="Texto alternativo de la imagen"
							/>
							<div className="canales-comunicaci-n">Tableros </div>
						</div>
						<div className="frame-749">
							{boards.map((board) => (
								<div className="canales-tablero-agregar" key={board.idBoard}>
									<div className="icono-tablero" width="16" height="15">
										<img
											src="/images/Icono_tablero.png"
											alt="Texto alternativo de la imagen"
										/>
									</div>
									<div className="nombre">
										<Link
											href={`/login/${user.id}/home/${idWorkspace}/board/${board.idBoard}`}
										>
											{board.boardName == 'Demo Board'
												? 'General'
												: board.boardName}
										</Link>
									</div>
								</div>
							))}
							<div className="canales-tablero-agregar2">
								<div className="icono-agregar2" width="16" height="17">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								{addBoardInput ? (
									<div className="add_new">
										<input
											type="text"
											placeholder="Escribe el nombre"
											value={newBoardName}
											onChange={(e) => setNewBoardName(e.target.value)}
										/>
										<div>
											<button onClick={handleSubmitNewBoard}>Crear</button>
											<button
												onClick={() => {
													setNewBoardName('');
													setAddBoardInput(false);
												}}
											>
												Cancelar
											</button>
										</div>
									</div>
								) : (
									<div
										className="nombre"
										onClick={() => setAddBoardInput(true)}
									>
										Agregar Tablero
									</div>
								)}
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
	);
};
