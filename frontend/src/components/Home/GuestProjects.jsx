import { ShapeProjects } from '@/layouts/ShapeProjects';
import { CardProject } from './CardProject';

import styleProject from '@/styles/home/projects.module.css';
import { CardEmpty } from './CardEmpty';

export const GuestProjects = ({ dataGuests }) => {
	const notice = (
		<>
			No fuiste invitado a ningún proyecto 😟
			<br />
			¡Invita a tus amig@s a crear un proyecto! 🥳 🥳
		</>
	);
	const lengthData = dataGuests ? dataGuests.length : 0;
	const data =
		lengthData > 0 ? (
			dataGuests.map((guest) => (
				<CardProject
					key={guest.id}
					img={guest.imgProject}
					dataMembers={guest.members}
					nameProject={guest.nameProject}
					nameProjectOwner={guest.nameProjectOwner}
				/>
			))
		) : (
			<CardEmpty notice={notice} />
		);

	return (
		<ShapeProjects
			styles={styleProject.projectGuest}
			styleHeader={styleProject.headerGuest}
			name="Proyectos a los que fuiste invitado"
		>
			{data}
		</ShapeProjects>
	);
};
