import { ShapeProjects } from '@/layouts/ShapeProjects';
import { CardProject } from './CardProject';
import styleProject from '@/styles/home/projects.module.css';
import { CardEmpty } from './CardEmpty';

export const Projects = ({ dataProjects, idUser }) => {
	const notice = (
		<>
			Todavía no creaste ningún proyecto,
			<br />
			¡hazlo! 🚀 🚀 🚀
		</>
	);

	if (dataProjects === null) {
		return (
			<ShapeProjects
				styles={styleProject.project}
				styleHeader={styleProject.header}
				name="Tus Proyectos"
				lengthData={undefined}
				btnCreate={true}
				idUser={idUser}
			>
				<CardEmpty notice={'Cargando...'} />
			</ShapeProjects>
		);
	}

	if (dataProjects === undefined) {
		return (
			<ShapeProjects
				styles={styleProject.project}
				styleHeader={styleProject.header}
				name="Tus Proyectos"
				lengthData={dataProjects.length}
				btnCreate={true}
				idUser={idUser}
			>
				<CardEmpty notice={notice} />
			</ShapeProjects>
		);
	}

	const data = dataProjects.map((project) => (
		<CardProject
			key={project.idSpace}
			img={project.imageEntity}
			nameProject={project.name}
			idSpace={project.idSpace}
			idUser={idUser}
		/>
	));

	return (
		<ShapeProjects
			styles={styleProject.project}
			styleHeader={styleProject.header}
			name="Tus Proyectos"
			lengthData={dataProjects.length}
			btnCreate={true}
			idUser={idUser}
		>
			{data}
		</ShapeProjects>
	);
};
