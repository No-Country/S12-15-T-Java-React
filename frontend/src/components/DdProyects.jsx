import Link from 'next/link';

function DdProyects() {
	return (
		<div>
			<ul className="menu">
				<li>
					<h2 className="dd-title">
						Proyects
						<img src="\images\flecha3.png" className="flecha" alt="" />
					</h2>

					<ul className="submenu">
						<li className="option">
							<Link className="link" href="#">
								<img src="/images/recent.png" className="flecha" alt="" />
								Proyect 1
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								<img src="/images/recent.png" className="flecha" alt="" />
								Proyect 2
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								<img src="/images/recent.png" className="flecha" alt="" />
								Proyect 3
							</Link>{' '}
						</li>
					</ul>
				</li>
			</ul>
		</div>
	);
}

export default DdProyects;
