import { ShapeProjects } from '@/layouts/ShapeProjects';
import { CardProject } from './CardProject';

import styleProject from '@/styles/home/projects.module.css';
import { CardEmpty } from './CardEmpty';

export const Projects = ({ dataProjects }) => {
	const notice = (
		<>
			Todavía no creaste ningún proyecto,
			<br />
			¡hazlo! 🚀 🚀 🚀
		</>
	);
	const lengthData = dataProjects ? dataProjects.length : 0;
	const data =
		lengthData > 0 ? (
			dataProjects.map((project) => (
				<CardProject
					key={project.id}
					img={project.imgProject}
					dataMembers={project.members}
					nameProject={project.nameProject}
				/>
			))
		) : (
			<CardEmpty notice={notice} />
		);

	return (
		<ShapeProjects
			styles={styleProject.project}
			styleHeader={styleProject.header}
			name="Tus Proyectos"
			btnCreate={true}
		>
			{data}
			{/* {dataProjects.map((project) => (
				<CardProject
					key={project.id} // Agrega una clave única para cada proyecto
					img={project.imgProject}
					dataMembers={project.members}
					nameProject={project.nameProject}
				/>
			))} */}
		</ShapeProjects>
	);
};
