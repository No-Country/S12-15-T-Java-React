import styleProject from '@/styles/home/projects.module.css';

export const ShapeProjects = ({ name, children, styles, styleHeader }) => {
	return (
		// <main className={ styleProject.project }>
		<main className={styles}>
			{/* <header className={ styleProject.header }>  */}
			<header className={styleHeader}>
				{name}
				<button className={styleProject.buttonCreate}> Crear </button>
			</header>
			<div> {children} </div>
			<footer className={styleProject.footer}> Ver más </footer>
		</main>
	);
};
