import { ShapeProjects } from '@/layouts/ShapeProjects';
import { CardProject } from './CardProject';

import styleProject from '@/styles/home/projects.module.css';

export const Projects = ({ dataProjects }) => {
	return (
		<ShapeProjects
			styles={styleProject.project}
			styleHeader={styleProject.header}
			name="Tus Proyectos"
		>
			{dataProjects.map((project) => (
				<CardProject
					key={project.id} // Agrega una clave única para cada proyecto
					img={project.imgProject}
					dataMembers={project.members}
					nameProject={project.nameProject}
				/>
			))}
		</ShapeProjects>
	);
};
