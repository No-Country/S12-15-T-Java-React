import { ShapeProjects } from '@/layouts/ShapeProjects';
import { CardProject } from './CardProject';

import styleProject from '@/styles/home/projects.module.css';

export const Projects = () => {
	const image = '/images/projects.jpg';

	return (
		<ShapeProjects
			styles={styleProject.project}
			styleHeader={styleProject.header}
			name="Tus Proyectos"
		>
			<CardProject img={image} nameProject={'No Country-S12-15-T-Java-React'} />
		</ShapeProjects>
	);
};
