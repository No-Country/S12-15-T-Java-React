'use client';
import { useEffect, useState, Fragment } from 'react';
import '@/styles/activity.css';
import Link from 'next/link';
import {
	getChannels,
	getBoards,
	getWorkspaceData,
} from '@/app/api/workspace/workspaceApi';

export const Aside = ({ params }) => {
	const user = JSON.parse(localStorage.getItem('user'));
	const [workspace, setWorkspace] = useState({
		name: '',
	});
	const [channels, setChannels] = useState([]);
	const [boards, setBoards] = useState([]);
	const { idWorkspace } = params;

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
					console.log('boards', boardsData.data);
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
							<div className="vector" width="16" height="17">
								<img
									src="/images/Vector.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
							<div className="canales-comunicaci-n">
								Canales de comunicación
							</div>
						</div>
						<div className="frame-749">
							<div className="canales-tablero-agregar">
								{channels.map((channel) => (
									<Fragment key={channel.idChannel}>
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
									</Fragment>
								))}
							</div>

							<div className="canales-tablero-agregar2">
								<div className="icono-agregar" width="16" height="16">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">Agregar Canal </div>
							</div>
						</div>
					</div>
				</div>
				<div className="frame-738">
					<div className="frame-7492">
						<div className="seccion-tablero">
							<div className="vector" width="16" height="17">
								<img
									src="/images/Vector.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
							<div className="canales-comunicaci-n">Tableros </div>
						</div>
						<div className="frame-749">
							<div className="canales-tablero-agregar">
								{boards.map((board) => (
									<Fragment key={board.idBoard}>
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
									</Fragment>
								))}
							</div>
							<div className="canales-tablero-agregar2">
								<div className="icono-agregar2" width="16" height="17">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">Agregar Tablero </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
	);
};
