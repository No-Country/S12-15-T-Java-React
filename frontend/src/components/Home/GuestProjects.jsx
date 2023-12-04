import { ShapeProjects } from '@/layouts/ShapeProjects';
// import { CardProject } from './CardProject';

import styleProject from '@/styles/home/projects.module.css';

export const GuestProjects = () => {
	// const image = '/images/projects.jpg';
	// const imgMember = '/images/user.png';

	return (
		<ShapeProjects
			styles={styleProject.projectGuest}
			styleHeader={styleProject.headerGuest}
			name="Proyectos a los que fuiste invitado"
		>
			{/* <CardProject
				img={image}
				imgMember={imgMember}
				nameProject={'No Country-S12-15-T-Java-React'}
			/> */}
		</ShapeProjects>
	);
};