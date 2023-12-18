import Link from 'next/link';

function DdProyects() {
	return (
		<div>
			<ul className="menu">
				<li className="dd">
					<h2 className="dd-title">
						<Link href={'/Home'}>My Proyects</Link>
						<img src="\images\flecha.png" className="flecha" alt="" />
					</h2>

					<ul className="submenu">
						<li className="option">
							<Link className="link" href="#">
								Proyect 1
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Proyect 2
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Proyect 3
							</Link>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	);
}

export default DdProyects;
