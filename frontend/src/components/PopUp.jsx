/* 
- En el componente donde se requiere la popup (digamos board) se importa este componente popup
import PopUp from '@/components/PopUp';
también un useState
import { useState } from 'react';

- En el mismo componente en board se debe agregar el siguiente código

	const [isModalOpen, setIsModalOpen] = useState(false);

	const handleOpenModal = () => {
		setIsModalOpen(true);
	};

	const handleCloseModal = () => {
		setIsModalOpen(false);
	};

Esto es para que abra y cierre la popup

- Escribe el elemento PopUp y pasa las siguientes props para que funcione el open y close

	<PopUp isOpen={isModalOpen} onClose={handleCloseModal} />
 
- También se le aplica el onClick al butón para que abra la popup, por ejemplo así:

	<button onClick={handleOpenModal}>Abrir popup</button>

*/

import stylesModal from '@/styles/popup.module.css';
import { CiUser } from 'react-icons/ci';
import { IoClose } from 'react-icons/io5';
import Checklist from './CheckList';

const dataModal = {
	title: 'Título Card',
	autor: 'Pepito Pérez',
	description:
		'Todo el texto sobre lo que se quiera poner sobre la etiqueta. Se puede extender, no se cuanto deba ser lo lógico. Esto habría que pensar si tener una máximo de de caracteres para no romper tanto el diseño, que dicen? Sigo anotando para ver que tanto queda extendiéndolo.',
};

const PopUp = ({ isOpen, onClose }) => {
	const handleClose = () => {
		onClose();
	};

	return (
		<>
			{isOpen && (
				<div className={stylesModal.modal_overlay}>
					<div className={stylesModal.modal}>
						<button className={stylesModal.close_button} onClick={handleClose}>
							<IoClose />
						</button>
						<div className={stylesModal.title_section_modal}>
							<div className={stylesModal.title}>
								<svg
									xmlns="http://www.w3.org/2000/svg"
									width="24"
									height="25"
									viewBox="0 0 24 25"
									fill="none"
								>
									<path
										d="M23.9883 13.6449C23.9957 13.5969 23.9996 13.5485 24 13.5V7.5C23.9979 5.64412 23.2598 3.86485 21.9474 2.55255C20.6351 1.24025 18.8559 0.502081 17 0.5H7C5.14412 0.502081 3.36485 1.24025 2.05255 2.55255C0.740247 3.86485 0.00208104 5.64412 0 7.5V17.5C0.00208104 19.3559 0.740247 21.1351 2.05255 22.4474C3.36485 23.7598 5.14412 24.4979 7 24.5H13C13.0485 24.4996 13.0969 24.4957 13.1449 24.4883C13.154 24.487 13.163 24.4858 13.172 24.4842C13.2191 24.4761 13.2656 24.4647 13.3111 24.45C13.3128 24.4495 13.3146 24.4493 13.3163 24.4487C16.5953 23.3556 22.8556 17.0953 23.9487 13.8163C23.9493 13.8146 23.9495 13.8128 23.95 13.8112C23.9647 13.7657 23.9761 13.7191 23.9842 13.672C23.9858 13.663 23.987 13.654 23.9883 13.6449ZM2 17.5V7.5C2.00152 6.17438 2.52879 4.90349 3.46614 3.96614C4.40349 3.02879 5.67438 2.50152 7 2.5H17C18.3256 2.50152 19.5965 3.02879 20.5339 3.96614C21.4712 4.90349 21.9985 6.17438 22 7.5V12.5H19C17.1441 12.5021 15.3649 13.2402 14.0526 14.5526C12.7402 15.8649 12.0021 17.6441 12 19.5V22.5H7C5.67438 22.4985 4.40349 21.9712 3.46614 21.0339C2.52879 20.0965 2.00152 18.8256 2 17.5ZM14 21.8922V19.5C14.0015 18.1744 14.5288 16.9035 15.4661 15.9661C16.4035 15.0288 17.6744 14.5015 19 14.5H21.3922C19.8717 16.938 16.438 20.3717 14 21.8922Z"
										fill="#FAFBFC"
									/>
								</svg>
								<h4>{dataModal.title}</h4>
							</div>
							<span>
								<CiUser />
								&nbsp;&nbsp;Creado por {dataModal.autor}
							</span>
						</div>
						<div className={stylesModal.description_section_modal}>
							<div className={stylesModal.title}>
								<svg
									xmlns="http://www.w3.org/2000/svg"
									width="24"
									height="25"
									viewBox="0 0 24 25"
									fill="none"
								>
									<path
										d="M2.4 0.5H21.6C22.2365 0.5 22.847 0.752856 23.2971 1.20294C23.7471 1.65303 24 2.26348 24 2.9V17.3C24 17.9365 23.7471 18.547 23.2971 18.9971C22.847 19.4471 22.2365 19.7 21.6 19.7H16.8L12 24.5L7.2 19.7H2.4C1.76348 19.7 1.15303 19.4471 0.702944 18.9971C0.252856 18.547 0 17.9365 0 17.3V2.9C0 2.26348 0.252856 1.65303 0.702944 1.20294C1.15303 0.752856 1.76348 0.5 2.4 0.5ZM2.4 2.9V17.3H8.196L12 21.104L15.804 17.3H21.6V2.9H2.4ZM4.8 6.5H19.2V8.9H4.8V6.5ZM4.8 11.3H16.8V13.7H4.8V11.3Z"
										fill="#FAFBFC"
									/>
								</svg>
								<h4>Descripción</h4>
							</div>
							<textarea defaultValue={dataModal.description}></textarea>
						</div>
						<div className={stylesModal.checklist_section_modal}>
							<div className={stylesModal.title}>
								<svg
									xmlns="http://www.w3.org/2000/svg"
									width="24"
									height="25"
									viewBox="0 0 24 25"
									fill="none"
								>
									<path
										d="M6.53333 9.96667L4.66667 11.8333L10.6667 17.8333L24 4.5L22.1333 2.63333L10.6667 14.1L6.53333 9.96667ZM21.3333 21.8333H2.66667V3.16667H16V0.5H2.66667C1.2 0.5 0 1.7 0 3.16667V21.8333C0 23.3 1.2 24.5 2.66667 24.5H21.3333C22.8 24.5 24 23.3 24 21.8333V11.1667H21.3333V21.8333Z"
										fill="#FAFBFC"
									/>
								</svg>
								<h4>Checklist</h4>
							</div>
							<Checklist />
						</div>
						<div className={stylesModal.group_buttons}>
							<button className={stylesModal.btn_delete}>Eliminar</button>
							<button className={stylesModal.btn_save}>Guardar</button>
						</div>
					</div>
				</div>
			)}
		</>
	);
};

export default PopUp;
