import Link from 'next/link';

function DdProyects() {
	return (
		<div>
			<ul className="menu">
				<li className="dd">
					<h2 className="dd-title">
						<Link href={'/Home'}>Proyectos Recientes</Link>
						<img src="\images\flecha.png" className="flecha" alt="" />
					</h2>

					<ul className="submenu">
						<li className="option">
							<Link className="link" href="#">
								Proyect A
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Proyect B
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Proyect C
							</Link>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	);
}

export default DdProyects;
